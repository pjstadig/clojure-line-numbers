(ns clojure-line-numbers.core
  (:require [clojure.stacktrace])
  (:import (clojure.lang PersistentHashMap)))

(set! *warn-on-reflection* true)

(defrecord Thing [field])

(defn instance-field
  "I throw an exception in an instance field form."
  []
  (.field
   ^Thing (identity nil)))

(defn instance-field-assign
  "I throw an exception in an instance field assignment form."
  []
  (set!
   (.field
    ^Thing (identity nil))
   (identity nil)))

(defn static-field-assign
  "I throw an exception in a static field assignment form."
  []
  (set!
   PersistentHashMap/EMPTY
   (identity nil)))

(defn instance-method
  "I throw an exception in an instance method form."
  []
  (.without
   ^PersistentHashMap (identity nil)
   :key))

(defn static-method
  "I throw an exception in a static method form."
  []
  (PersistentHashMap/create
   ^java.util.Map (identity nil)))

(defn keyword-invoke
  "I throw an exception in a keyword invoke form."
  []
  (:key
   {}
   (identity :bar)
   (identity :baz)))

(defn invoke
  "I throw an exception in an invoke form."
  []
  ((identity nil)
   (identity nil)))

(defn threading
  "I throw an exception in a threading form."
  []
  (-> :foo
      (identity)
      (identity)
      ((identity nil))
      (identity)
      (identity)))

(defmacro print-boom [n & body]
  `(try
     ~@body
     (catch Throwable t#
       (clojure.stacktrace/print-trace-element (nth (.getStackTrace t#) ~n))
       (println))))

(defn -main [& args]
  (print-boom 0 (instance-field))
  (print-boom 0 (instance-field-assign))
  (print-boom 0 (static-field-assign))
  (print-boom 0 (instance-method))
  (print-boom 1 (static-method))
  (print-boom 2 (keyword-invoke))
  (print-boom 0 (invoke))
  (print-boom 0 (threading)))

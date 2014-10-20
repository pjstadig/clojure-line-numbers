(defproject clojure-line-numbers "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot clojure-line-numbers.core
  :profiles {:fix {:dependencies ^:replace [[name.stadig/clojure "1.7.0-linenumberfix-20141020.191148-1"]]}})

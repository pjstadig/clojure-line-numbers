# clojure-line-numbers

Demonstrates incorrect line numbers emitted by the Clojure compiler, and the fix
as described in [CLJ-1561](http://dev.clojure.org/jira/browse/CLJ-1561)
([http://dev.clojure.org/jira/browse/CLJ-1561](http://dev.clojure.org/jira/browse/CLJ-1561))

## Usage

To see the incorrect line numbers emitted, run:

    lein run

To see the line numbers emitted by the fix, run:

    lein with-profiles fix run

## Sample Output

    paul@samson:~/src/clojure-line-numbers$ lein run
    clojure_line_numbers.core$instance_field.invoke (core.clj:13)
    clojure_line_numbers.core$instance_method.invoke (core.clj:19)
    clojure_line_numbers.core$static_method.invoke (core.clj:26)
    clojure_line_numbers.core$keyword_invoke.invoke (core.clj:34)
    clojure_line_numbers.core$invoke.invoke (core.clj:40)
    clojure_line_numbers.core$threading.invoke (core.clj:46)
    paul@samson:~/src/clojure-line-numbers$ lein with-profiles fix run
    clojure_line_numbers.core$instance_field.invoke (core.clj:12)
    clojure_line_numbers.core$instance_method.invoke (core.clj:18)
    clojure_line_numbers.core$static_method.invoke (core.clj:25)
    clojure_line_numbers.core$keyword_invoke.invoke (core.clj:31)
    clojure_line_numbers.core$invoke.invoke (core.clj:39)
    clojure_line_numbers.core$threading.invoke (core.clj:48)

## License

Copyright © 2014 Paul Stadig

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

# clojure-line-numbers

Demonstrates incorrect line numbers emitted by the Clojure compiler, and the fix
as described in [CLJ-1561](http://dev.clojure.org/jira/browse/CLJ-1561)
([http://dev.clojure.org/jira/browse/CLJ-1561](http://dev.clojure.org/jira/browse/CLJ-1561))

## Usage

To see the incorrect line numbers emitted, run:
    lein run

To see the line numbers emitted by the fix, run:
    lein with-profiles fix run

## License

Copyright © 2014 Paul Stadig

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

# Typographer

This library converts standard ASCII punctuation into typographic smart characters. 

## Installation

[![Clojars Project](http://clojars.org/typographer/latest-version.svg)](http://clojars.org/typographer)

## Usage

Typographer is invoked in the same way whether you're using Clojure or ClojureScript. The `smarten` function takes a string containing plain ASCII punctuation and returns a string with that punctuation modified to high-ASCII 'fancy' counterparts. For example, a single-quote or apostrophe ' becomes a ’.

Typographer is smart, handling quotes within quotes and ensuring a single-quote faces the correct direction. For example '80s becomes ’80s. It also replaces an ellipses of periods '...' with a single-character ASCII ellipses '…' while two dashes '--' are transformed into an em-dash '—'.

Fancy!

## License

Copyright © 2014-2015 Akiva R. Schoen

Distributed under the Eclipse Public License either version 1.0 or any later version.

(defproject typographer "1.1.1"
  :description "Converts standard ASCII punctuation into typographic smart characters."
  :url "https://github.com/akivaschoen/typographer"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :source-paths ["src/clj" "src/cljs"]
  :clojurescript? true
  :cljsbuild
  {:builds {:main
            {:source-paths ["src/cljs"]
             :jar true
             :compiler {:output-to "js/typographer.js"
                        :optimizations :advanced
                        :pretty-print false}}}}
  :profiles
  {:dev {:dependencies [[org.clojure/clojurescript "0.0-2913"]]
         :plugins [[lein-cljsbuild "1.0.5"]]}})

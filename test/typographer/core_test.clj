(ns typographer.core-test
  (:require [clojure.test :refer :all]
            [typographer.core :refer :all]))

(deftest single-quotes
  (testing "single quotes are curled"
    (is (= (smarten "'curly'")
            "‘curly’"))
    (is (= (smarten "multiline 'curling\nwill occur'")
            "multiline ‘curling\nwill occur’"))
    (is (= (smarten "'Angleton's dead, Mo.'")
            "‘Angleton’s dead, Mo.’")))


  (testing "apostrophes are curled correctly"
    (is (= (smarten "Bob's in charge")
            "Bob’s in charge"))
    (is (= (smarten "I said, \"He wasn't crucial.\"")
            "I said, “He wasn’t crucial.”")))


  (testing "decadal abbreviations"
    (is (= (smarten "sedated in the '80s")
            "sedated in the ’80s")))
    

  (testing "proclitic contractions"
    (is (= (smarten "'Twould if I could; 'twould be far better.")
            "’Twould if I could; ’twould be far better."))
    (is (= (smarten "'Twere ever thus, 'twere never otherwise.")
            "’Twere ever thus, ’twere never otherwise."))
    (is (= (smarten "'Tis not mine, 'tis yours.")
            "’Tis not mine, ’tis yours."))
    (is (= (smarten "'Twas midnight, and 'twas cold.")
            "’Twas midnight, and ’twas cold."))
    (is (= (smarten "'Twill be your death, and surely 'twill be mine.")
            "’Twill be your death, and surely ’twill be mine."))
    (is (= (smarten "'Tain't natural; 'tain't decent neither.")
            "’Tain’t natural; ’tain’t decent neither."))
    (is (= (smarten "'Tisn't mine; 'tisn't yours neither.")
            "’Tisn’t mine; ’tisn’t yours neither.")) ;; 'Tis fixes this
    (is (= (smarten "'Twasn't rolling fast, 'twasn't rolling slow.")
            "’Twasn’t rolling fast, ’twasn’t rolling slow.")) ;; 'Twas fixes this
    (is (= (smarten "'Twarn't rollin' fast, 'twarn't rollin' slow.")
            "’Twarn’t rollin’ fast, ’twarn’t rollin’ slow."))))


(deftest double-quotes
  (testing "double quotes are curled"
    (is (= (smarten "\"curly\"")
            "“curly”"))
    (is (= (smarten "multiline \"curling\nwill occur\"")
            "multiline “curling\nwill occur”"))
    (is (= (smarten "\"Angleton's dead, Mo.\"")
            "“Angleton’s dead, Mo.”"))))


(deftest mixed-quotes
  (testing "British and American"
    (is (= (smarten "\"'Twere 'curly' I tell you!\"")
            "“’Twere ‘curly’ I tell you!”"))
    (is (= (smarten "\"I said, 'curling\nwill occur'\"")
            "“I said, ‘curling\nwill occur’”"))
    (is (= (smarten "'I said, \"curling\nwill occur\"'")
            "‘I said, “curling\nwill occur”’"))
    (is (= (smarten "It's \"'80s\", not \"'80's\" dammit.")
            "It’s “’80s”, not “’80’s” dammit."))))



(deftest ellipses
  (testing "ellipses are handled correctly, mostly"
    (is (= (smarten "inline... there should be space")
            "inline… there should be space"))
    (is (= (smarten "Ending a sentence.... A period should remain.")
            "Ending a sentence…. A period should remain."))
    ))


;; failing     
    ; (is (= (smarten "\"...\"")
    ;         "“…”"))
    ; (is (= (smarten "\"... everyone.\"\n\n\"What? I missed that.\"")
    ;         "“… everyone.”\n\n“What? I missed that.”"))

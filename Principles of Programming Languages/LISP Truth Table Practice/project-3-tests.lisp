(load "project-3.lisp")

; Keeps track of the number of tests passed and failed
(defvar tests-passed 0)
(defvar tests-failed 0)

; A helper function to format the test result string
; Takes in a boolean result and returns a string ("PASS" or "FAIL")
(defun format-result (result)
  (if result
      "PASS"
      "FAIL"))

; A function to run a test suite
; Takes in a list of tests and a name for the test suite.
; Prints the results of the test suite.
(defun test (tests name)
  (let ((results '()))
    (dolist (test tests)
      (push (eval test) results))
    (let ((result (every #'identity results)))
      (if result
          (incf tests-passed)
          (incf tests-failed))
      (format t "~%~a - ~a~%" name (format-result result)))
    (format t "  Details: ~a~%" (mapcar #'format-result results))))


; Tests for set-member
(test '((equal (set-member '(1 2) 1) t)
        (equal (set-member '(1 2) 3) nil))
      "set-member")

; Test cases for set-union
(test `((equal (set-union '(1 2) '(2 4)) '(1 2 4))
        (equal (set-union '(1 2 3) '(4 5 6)) '(1 2 3 4 5 6)))
      "set-union")

; Test cases for set-intersection
(test `((equal (set-intersection '(1 2) '(2 4)) '(2))
        (equal (set-intersection '(1 2 3) '(2 3 4)) '(2 3)))
      "set-intersection")

; Test cases for set-diff
(test `((equal (set-diff '(1 2) '(2 4)) '(1))
        (equal (set-diff '(1 2 3) '(2 3 4)) '(1)))
      "set-diff")

; Test cases for boolean-xor
(test `((equal (boolean-xor nil nil) nil)
        (equal (boolean-xor nil t) t)
        (equal (boolean-xor t nil) t)
        (equal (boolean-xor t t) nil))
      "boolean-xor")

; Test cases for boolean-implies
(test `((equal (boolean-implies nil nil) t)
        (equal (boolean-implies nil t) t)
        (equal (boolean-implies t nil) nil)
        (equal (boolean-implies t t) t))
      "boolean-implies")

; Test cases for boolean-iff
(test `((equal (boolean-iff nil nil) t)
        (equal (boolean-iff nil t) nil)
        (equal (boolean-iff t nil) nil)
        (equal (boolean-iff t t) t))
      "boolean-iff")

; Test cases for boolean-eval
(test `((equal (boolean-eval '(and t nil)) nil)
        (equal (boolean-eval '(and t (or nil t))) t)
        (equal (boolean-eval '(not (and t nil))) t)
        (equal (boolean-eval '(or t nil)) t)
        (equal (boolean-eval '(xor t nil)) t)
        (equal (boolean-eval '(implies t nil)) nil)
        (equal (boolean-eval '(iff t nil)) nil))
      "boolean-eval")

; Print the final test results
(format t "~%~%Test results: ~a passed, ~a failed~%" tests-passed tests-failed)
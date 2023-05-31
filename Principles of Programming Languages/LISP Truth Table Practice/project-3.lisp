; Return T if item is a member of set.
;; Return NIL if item is not a member of set.
;; The type of set is list.
(defun set-member (set item)
  (cond ((null set) nil)    ; If set is null, we return nil same thing as false
        ((equal (car set) item) t)  ; if the item is in the set return true
        (t (set-member (cdr set) item)))) ; if else its true and check the rest of the items are in the set


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the union of set-1 and set-2.
;; The result should contain no duplicates.
;; Assume set-1 contains no duplicates and set-2 contains no duplicates.
(defun set-union (set-1 set-2)
  (cond ((null set-1) set-2) ; if set 1 is null, return set 2
        ((set-member set-2 (car set-1)) (set-union (cdr set-1) set-2)) ;if first item of set-1 in set-2, call set-union on remaining items
        (t (cons (car set-1) (set-union (cdr set-1) set-2))))) ;else return item 1 of set-1 and call of set-union on remaining items of set1


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the intersection of set-1 and set-2.
;; The result should contain no duplicates.
;; Assume set-1 contains no duplicates and set-2 contains no duplicates.
(defun set-intersection (set-1 set-2) ;; Define a function called set-intersection that takes two arguments: set-1 and set-2.
    (cond ((null set-1) nil) ; Check if set-1 is empty. If it is, return nil (which means an empty set).
        ((set-member set-2 (car set-1)) ; Check if the first item in set-1 is also in set-2 by calling the set-member function with set-2 and the first item in set-1 as arguments. If it is, continue to the next line. If not, skip to the else clause.
        (cons (car set-1); If the first item in set-1 is also in set-2, add it to the intersection set by creating a new list with the first item in set-1 as its first element and the result of calling set-intersection recursively with the rest of set-1 and set-2 as its second argument.
        (set-intersection (cdr set-1) set-2)))
    (t (set-intersection (cdr set-1) set-2)))) ; If the first item in set-1 is not in set-2, skip to the else clause and call set-intersection recursively with the rest of set-1 and set-2 as its argument.


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the difference of set-1 and set-2.
;; The result should contain no duplicates.
;; Assume set-1 contains no duplicates and set-2 contains no duplicates.
(defun set-diff (set-1 set-2)
  (cond ((null set-1) nil) ; Set-1 is empty, done checking
        ((set-member set-2 (car set-1)) (set-diff (cdr set-1) set-2)) ; If the first item in set-1 is in set-2, check the rest of set-1
        (t (cons (car set-1) (set-diff (cdr set-1) set-2))))) ; If the first item in set-1 is not in set-2, add it to the list and check the rest of set-1


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the exclusive or of a and b
(defun boolean-xor (a b)
  (cond ((and a b) nil)  ; if a and b (T, T): return nil
        ((or a b) t)  ; if a or b (T, F), (F, T): return true
        (t nil)))  ; else, (F, F): return nil


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the implication of a and b
(defun boolean-implies (a b) ;; Takes in the arguments a and b
    (if(and a (not b)) nil t)) ; if a is true and b not true return false otherwise reurn true



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Return the bi-implication (if and only if) of a and b
(defun boolean-iff (a b)
  (if (and a b) ; if a and b are true
      t ; return true
      (if (and (not a) (not b)) ; if a and b are false
          t nil))) ; return true, else return false


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Evaluate a boolean expression.
;; Handle NOT, AND, OR, XOR, IMPLIES, and IFF.
(defun boolean-eval (expr)
  (cond ((eq expr 't) t) ; If expr is t, return t
        ((eq expr 'nil) nil) ; If expr is nil, return nil
        (t (let ((op (car expr))) ; get the operator
          (cond ; Check the operator and recursively call boolean-eval on the rest of the expression
            ((equal op 'not) (not (boolean-eval (second-item expr))))
            ((equal op 'and) (and (boolean-eval (second-item expr))
                                  (boolean-eval (third-item expr))))
            ((equal op 'or) (or (boolean-eval (second-item expr))
                                (boolean-eval (third-item expr))))
            ((equal op 'xor) (boolean-xor (boolean-eval (second-item expr))
                                          (boolean-eval (third-item expr))))
            ((equal op 'implies) (boolean-implies (boolean-eval (second-item expr))
                                                  (boolean-eval (third-item expr))))
            ((equal op 'iff) (boolean-iff (boolean-eval (second-item expr))
                                          (third-item expr))))))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Helper functions

;; Return the second item in a list
(defun second-item (list)
  (car (cdr list)))

;; Return the third item in a list
(defun third-item (list)
  (car (cdr (cdr list))))
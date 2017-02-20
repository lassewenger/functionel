;; Lisp syntax on variables

;;
;; Preamble: Syntax
;;

;; Defining a mutable variable
(setf a 10)

;; Using let-bindings
;; Contains two arguments
;;   1. A list of variables and their values
;;   2. A body of code using the variables
(let ((n 20))
  (write n)
)

;;
;; Exercises
;;

;; Exercise 1
;; Define a global variable 'a' with value 42
;; Note: This is impossible in true functional programming

;; Exercise 2
;; Write a let-binding where you define two variables: a = 10 and b = 20
;; In the body of the let-binding you should print the sum of a and b

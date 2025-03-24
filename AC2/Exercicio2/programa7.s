.text
.globl _start

_start:

    li s0, 2147483647
    li s1, 8192
    li s2, 4

    mul s3,s1,s2
    sub s4,s0,s3
     
    nop
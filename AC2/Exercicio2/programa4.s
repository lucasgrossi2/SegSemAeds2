.text
.globl _start

_start:

    li s0,1
    li s1,5
    li s2,15

    mul s3,s1,s0
    add s4,s3,s2

    nop
.text
.globl _start

_start:
    li s0,2 
    li s1,3
    li s2,4
    li s3,5

    add s4,s0,s1
    add s5,s2,s3
    add s6,s4,s5

    sub s7,s0,s1
    add s8,s7,s6

    sub s1,s6,s8
    
    nop
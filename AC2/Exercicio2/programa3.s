.text
.globl _start

_start:

    li s0,3     #x
    li s1,4     #y
    li s2,15    #15
    li s3,67    #67 
    li s4,4     #4

    sub s5,s2,s0 #(15-x)
    sub s6,s3,s1 #(67-y)

    add s7,s5,s6 #(15-x)+(15-x)
    add s8,s7,s4

    nop
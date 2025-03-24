.text
.globl _start

_start:

    li s0,1
    sll s1,s0,20
    sll s2,s0,12

    add s3,s1,s2

    nop
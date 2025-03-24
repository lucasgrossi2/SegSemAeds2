.text
.globl _start

_start:

    li s0,0x12345678    #00010010001101000101011001111000       

    #0x12 = 00010010
    srli s1,s0,24

    #0x34 = 00110100
    slli s2,s0,8
    srli s2,s2,24

    #0x56 = 01010110
    slli s3,s0,16
    srli s3,s3,24

    #0x78 = 01111000
    slli s4,s0,24
    srli s4,s4,24

    nop
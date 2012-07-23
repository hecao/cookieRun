#!/usr/bin/env python
import sys

fileName = "./Untitled 2_default.xml"
if len(sys.argv) > 1 :
    fileName = sys.argv[1]

def getAttr(name, str):
    start = str.find(name + "=\"") 
    start += (len(name) + 2)
    result = -1
    if (start > (len(name) + 2)) :
        end = str.find("\"", start)
        print start, end
        result = str[start : end]
        return result
    return -1

file = open(fileName)
result = ""
try:
    lines = file.readlines()
finally:
    file.close()

for line in lines:
    r1 = getAttr("x", line)
    if r1 != -1 :
        result += str(r1) + ", "
    r2 = getAttr("y ", line)
    if r2 != -1 :
        result += str(r2) + ", "
    r3 = getAttr("height", line)
    if r3 != -1 :
        result += str(r3) + ", "
    r4 = getAttr("width", line)
    if r4 != -1 :
        result += str(r4) + ", "

if len(result) > 0 :
    result = result[0 : (len(result) - 2)]

print result 

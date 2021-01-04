print("sample text")

x=50
# adds space automatically with ","
print("jo bat hai",x)
# doesnt add space with "+"
print("jo bat hai"+str(x))
# to ensure no endline
print("sampletext1",end="")
# tab space instead of endline
print("sampletext2",end="\t")
print("sampletext3")

# fstring syntax for printing, variables in {}
print(f"jo bat hai {x}")

# to find a var type
print(type(x))

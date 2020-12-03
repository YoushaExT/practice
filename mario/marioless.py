height = int(input("Height: "))

for i in range(height):
    # spaces
    for j in range(height-i-1):
        print(f" ",end="")
    # hashes
    for j in range(i+1):
        print(f"#",end="")
    # nextline
    print()

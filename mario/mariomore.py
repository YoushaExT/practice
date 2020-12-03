# keep promting for input in range of 1-8
while True:
    height = int(input("Height: "))
    if height>=1 and height<=8:
        break;

for i in range(height):
    # spaces
    for j in range(height-i-1):
        print(f" ",end="")
    # hashes
    for j in range(i+1):
        print(f"#",end="")
    # double spaces
    print("  ",end="")
    # hashes
    for j in range(i+1):
        print(f"#",end="")
    # nextline
    print()

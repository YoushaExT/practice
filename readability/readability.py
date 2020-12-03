# program that computes the approximate grade level needed to comprehend some text
txt = input("Text: ")

sentences=0
words=0
letters=0
for i in txt:
    if i == "!" or i == ".":
        sentences += 1
    if i == " ":
        words += 1
    if i.isalpha():
        letters += 1

# first word won't have space bar
if words!=0:
    words +=1

# print(sentences,words,letters)

L = 100*letters/words
S = 100*sentences/words

index = 0.0588 * L - 0.296 * S - 15.8
index = round(index)

# print(L,S)
#
# print(index)

if index<1:
    print("Before Grade 1")
elif index>16:
    print("Grade 16+")
else:
    print(f"Grade {index}")

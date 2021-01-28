can use a//b for floor division instead of int(a/b)

enumerate() can be used on an iterable to return a tuple with index,value pair e.g. for count,element in enumerate(list)

[  for key,value in dict.items()  ] useful for iterating in dict

The assert keyword is used when debugging code. If condition returns True, then nothing happens but if condition returns False, AssertionError is raised. (can create test.py and compare expected to actual values for testing functions instead of printing out on console).
Usage assert<statement>,<"this message is displayed on failure">

.get can be used on a dictionary object to get a default value. This way there is no need to initialize the dictionary and increment separately. E.g. d[char]=d.get(char,0)+1
is same as initializing all d[char] to 0 then incrementing by 1.

string.join(list) converts list to a str, the string would fill the gaps within the elements of the list. E.g. ','.join([1,2]) --> '1,2'

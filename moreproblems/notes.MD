can use a//b for floor division instead of int(a/b)

enumerate() can be used on an iterable to return a tuple with index,value pair e.g. for count,element in enumerate(list)

[  for key,value in dict.items()  ] useful for iterating in dict

The assert keyword is used when debugging code. If condition returns True, then nothing happens but if condition returns False, AssertionError is raised. (can create test.py and compare expected to actual values for testing functions instead of printing out on console).
Usage assert<statement>,<"this message is displayed on failure">

# Write a function to compute 5/0 and use try/except to catch the exceptions.

def throws():
    return 5/0

try:
    throws()
except ZeroDivisionError:
    print("division by zero!")
except Exception:
    print('Caught an exception')
finally:
    print('In finally block for cleanup')


# Finally block can be useful to close objects and clean up resources.
# Finally block makes a difference if you return early
# try:
#     run_code1()
# except TypeError:
#     run_code2()
#     return None   # The finally block is run before the method returns
# finally:
#     other_code()

# Other situations that can cause differences:
#
# If an exception is thrown inside the except block.
# If an exception is thrown in run_code1() but it's not a TypeError.
# Other control flow statements such as continue and break statements.

import os
def file_check() :
    if os.path.isfile("email.txt") !=True :
        f=open("email.txt",'w')
    if os.path.isfile("password.txt") != True :
        f=open("password.txt",'w')
from filecheck import *
import smtplib
from random import randint
s=smtplib.SMTP("smtp.gmail.com",587)
s.starttls()
s.login("developersegroup1@gmail.com","developer@se1")
class Student :
    def __init__(self,user_name,rollno,branch,password) :
        self.user_name=user_name
        self.branch=branch
        self.rollno=rollno
        self.password=password
    def register(self) :
        f=open("email.txt",'r')
        lst=f.read().split('\n')
        if self.user_name not in lst :
            f=open("email.txt",'a')
            p=open("password.txt",'a')
            f.write(self.user_name+'\n')
            p.write(self.password+'\n')
            print("register successful")
        else :
            print("user_name already registered ")
    def login(self) :
        f=open("email.txt",'r')
        p=open("password.txt",'r')
        lst=f.read().split('\n')
        lst1=p.read().split('\n')
        if self.user_name in lst and self.password in lst1 :
            if lst.index(self.user_name)== lst1.index(self.password) :
                print("login successful ")
        else :
            print("not registered please create your account\n incorrect email or password !")
    def exitout()   :
        print("you exitted from the window ")
        s.quit()
        exit()
    def forgot_password(user_name) :
        otp=str(randint(123456,999999))
        s.sendmail("developersegroup1@gmail.com",user_name,otp)
        print("otp sent succesfully")
        Student.check(otp,user_name)
    def check(otp,user_name) :
        user_response=input("enter the otp : ")
        if otp==user_response :
           f=open("email.txt",'r')
           ff=f.read().split('\n')
           h=ff.index(user_name)
           f=open("password.txt",'r')
           ff=f.read()
           temp_lst=ff.split('\n')
           new_password=input("enter the password :")
           temp_lst[h]=new_password
           f=open("password.txt",'w')
           f.write("\n".join(temp_lst)) 
           print("password changed successfully ")
file_check()
while(True) :
    print("LOGIN : 1","\n","REGISTER : 2",'\n',"EXIT : 3",'\n',"forgot password : 4")
    choice=int(input("enter your choice : ")) 
    if choice ==3 :
        Student.exitout()
    elif choice==4 :
        temp=input("enter the email : ")
        tt=open('email.txt','r')
        temp_lst=tt.read().split('\n')
        if temp in temp_lst : 
            Student.forgot_password(temp)
        else :
            print("invalid email !")
        user_name=input("enter the username : ")
        rollno=input("enter the roll number : ")
        branch=input("enter the branch      : ")
        password=input("enter the password  : ")
    elif choice==2 :
        user_name=input("enter the username : ")
        rollno=input("enter the roll number : ")
        branch=input("enter the branch      : ")
        password=input("enter the password  : ")
        conf_password=input("confirm password by entering same password again : ")
        if conf_password != password :
            print("enter the correct password as  you entered ")
        else :
                temp=Student(user_name,rollno,branch,password)
                temp.register()
    elif choice==1:
        user_name=input("enter the username : ")
        password=input("enter the password  : ")
        temp=Student(user_name,rollno,branch,password)
        temp.login()
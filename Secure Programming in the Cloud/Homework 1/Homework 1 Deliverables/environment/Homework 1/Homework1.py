# File: Homework1.py
# Author: Ben Brandhorst
# Date: March 24th, 2020
# Purpose: SDEV400 Homework

from random import randrange
import logging

import time


## Command line menu format source https://extr3metech.wordpress.com/2014/09/14/simple-text-menu-in-python/
def print_menu():       
    print (50 * '-' , 'MENU' , 50 * '-')
    print ("Welcome to Ben Brandhorst's SDEV400 Homework 1 Submission. Please select from the menu below.")
    print ('')
    print ('1. Create a S3 bucket with the name consisting of your firstname, lastname and a random 6- digit suffix.')
    print ('2. Upload File1.txt and File2.txt to benbrandhorst1 bucket.')
    print ('3. Delete Uploaded1.txt from benbrandhorst1.')
    print ('4. Delete an empty bucket from a list of buckets.')
    print ('5. Copy Uploaded2 from benbrandhorst1 to benbrandhorst2.')
    print ('6. Download Copied1.txt from benbrandhorst2.')
    print ('7. Exit the Program')
    print (107 * '-')


loop=True      
while loop:
    print_menu()
    choice = input('Enter your choice [1-7]: ')
    if choice==('1'):
        # Runs bucket() method to create a new bucket
        bucket()    
    elif choice==('2'):
        # Runs upload() method to upload objects
        upload()
    elif choice==('3'):
        # Runs deleteFile() method to delete files
        deleteFile()
    elif choice==('4'):
        # Runs deleteBucket() method to delete selected bucket
        deleteBucket()
    elif choice==('5'):
        # Runs copyObject() method to copy object from one bucket to another
        copyObject()
    elif choice==('6'):
        # Runs downloadFile() method to download file from bucket
        downloadFile()
    elif choice==('7'):
        # Exits program
        print("You have selected 'Exit Program'")
        displayTime()
        loop=False 
    else:
        # Any integer inputs other than values 1-7 returns this error
        input("Wrong option selection. Enter any key to try again.")
        
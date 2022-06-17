#!/usr/bin/env python
# coding: utf-8

# In[11]:


#Insertion sort
Input_Data = list(eval(input("Input_Data: ")))

def Insertion_sort(data):
    for j in range(1, len(data)):
        key = data[j]
        i = j-1
        while i >= 0 and data[i] > key:
            data[i+1] = data[i]
            i -= 1
        data[i+1] = key
    return data

Insertion_sort(Input_Data) 


# In[48]:


#Merge sort

Input_Data = list(eval(input("Input_Data: ")))

#left表示左半開頭的index ; right 表示右半結尾的index 
def Merge(data, left , right, middle):
    n1 = middle - left + 1
    n2 = right - middle
    #額外建立兩個list儲存左半＆右半
    Left = []
    Right = []
    for i in range(0, n1):
        Left.append(data[left + i ]) 
    for j in range(0, n2 ):
        Right.append(data[middle + j + 1])
    #建立semtinel（比input任一資料大的數）
    Left.append(max(data) + 1)
    Right.append(max(data) + 1)
    i = 0
    j = 0
    #左半右半比較並放入data，若沒有sentinel則會out of index
    for k in range(left, right+1):
        if(Left[i] <= Right[j]):
            data[k] = Left[i]
            i += 1           
        else:
            data[k] = Right[j]
            j += 1
    
    
def Merge_sort(data, left, right):
    if(left < right):
        middle = (left + right) // 2
        #Divide
        Merge_sort(data, left, middle)
        Merge_sort(data, middle+1, right)
        #Combine
        Merge(data, left, right, middle)
        return data
    
Merge_sort(Input_Data, 0, len(Input_Data)-1)


# In[33]:


L =[ 1, 2, 3, 4, 5]
max(L)


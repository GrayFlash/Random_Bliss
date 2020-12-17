#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from bs4 import BeautifulSoup
import requests
import pandas as pd
import numpy as np


# In[ ]:


def make_soup(url):
    return BeautifulSoup(requests.get(url).text, 'html.parser')


# In[ ]:


def get_links(url):
    page_soup = make_soup(url)
    links = []
    
    main = page_soup.find('div', {'class':'mid'})
    li_tags = main.find_all('li')
    
    for i in li_tags:
        x = i.find_all('a')
        for j in x:
            li = j.get('href')
            links.append(li)
            print(li)
    return links


# In[ ]:


all_food_links = get_links("https://dir.indiamart.com/industry/agro-farm.html")


# In[ ]:


def products_from_links(url, items):
    page_soup = make_soup(url)
    #items = []
    
    divs = page_soup.find_all('div', {'class':'sid_nm'})
    
    for i in divs:
        x = i.find('a').text
        items.append(x)
        print(x)
    
    lis = page_soup.find_all('li', {'class':'lst'})
    print("\n\ndiff")
#     print(lis)
    
    for i in lis:
        try:
            x = i.find('a',{'class':'fs18'}).text
            items.append(x)
            print(x)

            small_tabs = i.find_all('a',{'class':"smTle"})
            for j in small_tabs:
                y = j.text
                print(y)
                items.append(y)
        except:
            pass

    print("\n\n Next \n\n")
    return items


# In[ ]:


food_items = []


# In[ ]:


base_url = "https://dir.indiamart.com"


# In[ ]:


# food_items = products_from_links(base_url+"/impcat/rice.html", food_items)
for li in all_food_links:
    food_items = products_from_links(base_url+str(li), food_items)


# In[ ]:


len(food_items)


# In[ ]:


df = pd.DataFrame(np.array(food_items), columns=["Food Item"])
df


# In[ ]:


df.to_csv('Food.csv', index=False)


# In[ ]:


all_cloth_links = get_links("https://dir.indiamart.com/industry/apparel-garments.html")


# In[ ]:


clothing_items = []
for li in all_cloth_links:
    clothing_items = products_from_links(base_url+str(li), clothing_items)


# In[ ]:


len(clothing_items)


# In[ ]:


df = pd.DataFrame(np.array(clothing_items), columns=["Clothing Item"])
df.to_csv('Clothes.csv', index=False)
df


# In[ ]:


all_household_links = get_links("https://dir.indiamart.com/industry/electronic-goods.html")
household_items = []
for li in all_household_links:
    household_items = products_from_links(base_url+str(li), household_items)


# In[ ]:


len(household_items)


# In[ ]:


df = pd.DataFrame(np.array(household_items), columns=["Household Item"])
df.to_csv('Household.csv', index=False)
df


# In[ ]:


all_hygiene_links = get_links("https://dir.indiamart.com/industry/home-supplies.html")

for li in all_hygiene_links:
    hygiene_items = products_from_links(base_url+str(li), hygiene_items)


# In[ ]:


len(hygiene_items)


# In[ ]:


df = pd.DataFrame(np.array(hygiene_items), columns=["Hygiene Item"])
df.to_csv('Hygiene.csv', index=False)
df


# In[ ]:


all_education_links = get_links("https://dir.indiamart.com/industry/education-training.html")
for li in all_education_links:
    education_items = products_from_links(base_url+str(li), education_items)


# In[ ]:


df = pd.DataFrame(np.array(education_items), columns=["Education Item"])
df.to_csv('Education.csv', index=False)
df


# In[ ]:


all_other_links = get_links("https://dir.indiamart.com/industry/gems-jewellery.html")
# other_items = []
for li in all_other_links:
    other_items = products_from_links(base_url+str(li), other_items)


# In[ ]:


df = pd.DataFrame(np.array(other_items), columns=["Other Item"])
df.to_csv('Other.csv', index=False)
df


# In[ ]:





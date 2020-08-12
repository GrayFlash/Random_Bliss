from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_distances , cosine_similarity
text = ["London Paris London", "Paris Paris London"]

cv = CountVectorizer()

X = cv.fit_transform(text)
List = X.toarray()
dis = cosine_similarity(X)
print(dis)
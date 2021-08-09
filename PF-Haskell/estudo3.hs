

type Mat a = [[a]]

dimOK :: Mat a -> Bool
dimOK [a] = True
dimOK (h:h1:t) | length h == length h2 = dimOK (h1:t) 
			   | otherwise = False

dimMat:: Mat a => Mat a -> (Int,Int)
dimmat (h:t) = (length (h:t),length h)

addMat:: Num a => Mat a -> Mat a -> Mat a
addmat (h:t) (h1:t2) = 

multi:: Num a => [a] -> [a] -> [a]
multi (h1:h2t) (c1:c2:t1) | h1*c1

zipWMat :: (a -> b -> c) -> Mat a -> Mat b -> Mat c
zipWMat f (h:t) (h1:t1)  
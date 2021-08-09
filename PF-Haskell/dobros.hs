dobros:: [Float] -> [Float]
dobros [] = []
dobros (h:t) = 2*h:dobros t

numocorre :: Char -> String -> Int 
numocorre a [] = 0
numocorre a (h:t) | h==a = 1+ numocorre t 
                  | otherwise 1- numocorre t

positivo :: [Int] -> Bool
positivo [] = False
positivo (h:t) | h <= 0 then False
               | h > 0 = positivos t


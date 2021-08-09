perimetro:: Double -> Double 
perimetro r = pi*r

dist :: (Double,Double) -> (Double,Double) -> Double
dist (x,y) (a,b) = sqrt ((a-x)^2+(b-y)^2)

primUlt:: [a] -> (a,a)
primUlt (h:t) = (h,last t)

multiplo:: Int -> Int -> Bool
multiplo m n | mod n m == 0 = True
			 | otherwise = False 



type Hora = (Int,Int)

horaValida:: Hora -> Bool
horaValida (x,y) | x>=0 && x<=23 && y>=0 && y<60 = True
				 | otherwise = False

horaDps:: Hora -> Hora -> Bool
horaDps (x1,y1) (x2,y2) | x2 > x1 = True
						| x2 == x1 && y2 > y1 = True
						| otherwise = False

horaToMint:: Hora -> Int
horaToMint (x,y) = x*60 + y

mintToHora:: Int -> Hora
mintToHora x = (div x 60, mod x 60)

difHoras:: Hora -> Hora -> Int
difHoras a b = (horaToMint b - horaToMint a)


addMint:: Hora -> Int -> Hora
addMint (x,y) a | (y+a)<60 = (x,y+a)
				| otherwise = (x + div a 60, y + mod a 60)
 










data Hora = H Int Int 
	deriving Show

type Etapa = (Hora,Hora)
type Viagem = [Etapa]

etapaOk:: Etapa -> Bool
etapaOk (H x1 y1,H x2 y2) | testaHora (H x1 y1) == True && testaHora (H x2 y2) == True && x2>x1 = True
						  | testaHora (H x1 y1) == True && testaHora (H x2 y2) == True && x2=x1 && y2>y1 = True
						  | otherwise = False

testaHora:: Hora -> Bool
testaHora H a b | a>0 && a<=24 && b>0 && b<=60 = True
				| otherwise = False


testaViagem:: [Etapa] -> Bool
testaViagem [] = True
testaViagem ((H a b,H a1 b1):(H c d,H c1 d1):t) | etapaOk (H a b,H a1 b1) == True && etapaOk (H c d,H c1 d1)== True && horaDps (H a b,H a1 b1) (H c d,H c1 d1)== True = testaViagem t
				  								| otherwise = False 

horaDps:: Hora -> Hora -> Bool
horaDps (H a b) (H a1 b1) | a > a1 = True
						| a == a1 && b1 > b = True
						| otherwise = False

data Ponto = Cartesiano Double Double | Polar Double Double
	deriving (Show,Eq)

data Figura = Circulo Ponto Double
			| Rectangulo Ponto Ponto
			| Triangulo Ponto Ponto Ponto
	deriving (Show,Eq)

type Poligonal = [Ponto]

posx:: Ponto -> Double 
posx Cartesiano a b = a
posx Polar x y = cos y * x

posy:: Ponto -> Double
posy Cartesiano a b = b
posy Polar x y = sin y *x

raio :: Ponto -> Double 
raio Polar x y = x
raio Cartesiano a b = sqrt( a^2 + b^2)

angulo :: Ponto -> Double 
angulo Cartesiano a b = arccos ((b^2 + (raio Cartesiano a b)^2 - a^2)/(2*b*(raio Cartesiano a b)))
angulo Polar x y = y

dist :: Ponto -> Ponto -> Double
dist a b = sqrt((posx b -posx a)^2 + (posy b - posy a)^2)

compLinha:: Poligonal -> Double
compLinha [a] = 0 
compLinha (h1:h2:t) = dist h1 h2 + compLinha t

linhaFechada:: Poligonal -> Bool
linhaFechada (h:t) | elem h t == True = True
				   | otherwise = False

--triangula :: Poligonal -> [Figura]



zoom:: Double -> Poligonal -> Poligonal
zoom x (p1:p2:t) | x*(dist p1 p2) 

[x | x <- [1..1024], ]



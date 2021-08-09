data hora = H Int Int
            deriving show
type Etapa = (Hora,Hora)
type Viagem = [Etapa]

V:: Viagem 
V = [(H 9 30, H 10 25),(H 11 20,H 12 45),(H 13 30, H 14 45)]

horaValida:: Hora -> Bool
horaValida (H h m) = h>=0 && h< 24 && m>=0 && m<60

maiorhora :: Hora -> Hora -> Bool
maiorhora (H h1 m1) (H h2 m2)  |h1 > h2 = True
                               |h1 ==h2 && m1 > m2 = True
                               |otherwise False


etapaValida :: Etapa -> Bool
etapaValida (hi hf) = horaValida hi && horaValida hf && maiorhora hf hi


Viagemvalida Viagem -> Bool
Viagemvalida [e] = etapaValida 
Viagemvalida (e:f:es) : etapaValida e && etapaValida f && maiorhora (fst f) (snd e) && Viagemvalida (f:es)

partidaChega :: Viagem -> (Hora, Hora)
partidaChega [x] = (fst x, snd x)
partidaChega (h:t)  = (fst h, snd(last t))

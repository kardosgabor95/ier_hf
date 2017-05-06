// Agent lift in project ier_hf_30.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+!call(lift,IDE) : true <- !move(lift,IDE).

+!move(lift,IDE,KI) : IDE == parkolo & kikerte(KI,_) <- .print("Vigye vissza a kulcsot!").

+!move(lift,IDE,KI) : IDE == parkolo & not kikerte(KI,_) <- !move(lift,IDE).

+!move(lift,IDE,KI) : IDE \== parkolo <- !move(lift,IDE).

+!move(lift,IDE) : true <- !at(lift,IDE).

+!at(lift,IDE) : at(lift,IDE) <- true.

+!at(lift,IDE) : not at(lift,IDE) <- move_to(IDE); !at(lift,IDE).

+!key_off(KI,TEREMSZAM) : true <- +kikerte(KI,TEREMSZAM).

+!key_in(KI,TEREMSZAM) : true <- -kikerte(KI,TEREMSZAM).

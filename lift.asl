// Agent lift in project ier_hf_30.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+!call(lift,IDE) : true <- !move(lift,IDE).

+!move(lift,IDE,KI) : IDE == -1 & kikerte(KI) <- .print("Vigye vissza a kulcsot!").

+!move(lift,IDE,KI) : IDE == -1 & ~kikerte(KI) <- !move(lift,IDE).

+!move(lift,IDE,KI) : IDE \== -1 <- !move(lift,IDE).

+!move(lift,IDE) : true <- !at(lift,IDE).

+!at(lift,IDE) : at(lift,IDE) <- true.

+!at(lift,IDE) : not at(lift,IDE) <- move_to(IDE); !at(lift,IDE).

+!key_off(KI) : true <- kikerte(KI).

+!key_in(KI) : true <- ~kikerte(KI).

// Agent parkolo in project ier_hf_30.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!erkezett("Tade","AAA-000","+36000000").

/* Plans */

+!erkezett(KI,RSZ,TEL) : true <- +ittvan(KI,RSZ,TEL); .send(lift, achieve, call(lift, -1));
.send(porta, achieve, azonosit(KI)).

+!tavozik(KI) : true <- -ittvan(KI,_,_).

+!ertesit(KI) : ittvan(KI,_,_) <- ?ittvan(KI,RSZ,TEL); 
.concat(KI,": ",RSZ,": ",TEL," hagyja el a parkolot! Izibe!",M); .print(M).

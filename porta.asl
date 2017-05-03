// Agent porta in project ier_hf_30.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

//kulcs kikerese a portarol
//szol a liftnek, hogy ki kerte ki a kulcsot
//ez alapján fogja lengedni a parkoloba az embereket
+!kulcs_ki(KI) : true <- send(lift, achieve, key_off(KI)).

+!azonosit(KI) : true <- .print(KI, "-t azonositom.").

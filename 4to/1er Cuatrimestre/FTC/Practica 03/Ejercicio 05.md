## El lenguaje $L_U  =  \{(<M>,  w)  |  M  \text{acepta}  w\}$ se conoce como lenguaje universal, y representa el problema general de aceptación. Probar que $L_U \in RE$.

Crea una MT $U$ que acepta $L_U$, por lo que $U$ simula $M$ (mediante $<M>$). Si $M$ acepta $w$, $U$ acepta $(<M>, w)$; si $M$ rechaza $w$, $U$ rechaza $(<M>, w)$; si $M$ loopea, $U$ loopea.
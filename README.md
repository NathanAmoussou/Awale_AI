## Objectifs
L'objectif de ce projet est d'implémenter un jeu d'Awalé aux règles modifiées pour y intégrer des IA (d'abord Minimax, peut-être MCTS ensuite).
L'idée serait de le faire dans plusieurs langages (Java, Python, Julia, peut-être C++ et Mojo) pour comparer les performances.
Comme il risque d'être difficile d'évaluer le niveau réel des IA (à part les faire jouer les unes contre les autres ou contre des IA randoms), on va privilégier des implémentations relativement simples du Minimax, peut-être d'un élagage Alpha-Beta, et on va plutôt mesurer les performances de vitesse avec plusieurs degrés d'optimisation.
## Règles de l'Awalé modifié
- Le jeu se joue à 2 joueurs à tour de rôle sur un plateau de 16 cases, dans le sens horaire (c'est à dire que la case qui suit la 16ème case est la 1ère case).
- Chaque case contient initialement 4 graines (2 bleues et 2 rouges), et pourra dans la partie contenir entre 0 et 16 graines au plus.
- Le joueur 1 contrôle les cases d'indice impair (1, 3, 5, 7, 9, 11, 13, 15) et le joueur 2 contrôle les cases d'indice pair (2, 4, 6, 8, 10, 12, 14, 16).
- À chaque tour, le joueur choisit une case qu'il contrôle et décide de jouer les graines bleues ou les graines rouges de cette case (si elle en possède encore).
- À partir d'une case choisie, jouer les graines bleues conciste à les « prendre » toutes, et à les distribuer dans les cases suivantes (une graine par case), dans le sens horaire, en commençant par la case suivante, jusqu'à ce qu'il n'y ait plus de graines à distribuer. Si une case possède déjà 16 graines, on ne distribue pas de graines dans cette case.
- À partir d'une case choisie, jouer les graines rouges conciste à les « prendre » toutes, et à les distribuer uniquement dans les cases adverses (une graine par case), dans le sens horaire, en commençant par la case suivante, jusqu'à ce qu'il n'y ait plus de graines à distribuer. Si une case adversaire possède déjà 16 graines, on ne distribue pas de graines dans cette case.
- Si la dernière graine d'un coup tombe dans une case contenant 1 ou 2 graines, cette case est capturée par le joueur qui a joué le coup, les graines sont retirées du jeu et placées dans le butin du joueur (son score). S'en suit une « chaîne de capture » où l'on remonte les cases précédents la case capturée pour voir si elles peuvent être capturées à leur tour (si elles possèdent 2 ou 3 graines). Si une case peut être capturée, on la capture et on continue la chaîne de capture. Si une case ne peut pas être capturée, on arrête la chaîne de capture.
- Un joueur qui ne peut plus jouer (toutes ses cases sont vides) a perdu la partie.
- Un joueur qui a un score supérieur à 32 a gagné la partie.
- Si les deux joueurs ont un score de 32 à la fin de la partie, c'est un match nul.

DATABASE NAME : BookProject

======================================================================================

BOOK SERVICE:

Provides the following functionalities :
	-Add a new Book to the Database
	-Remove an Existing Book From Database
	
	PORT: 8081
	
	BASE URL:/api/home/book
	
	SAVE BOOK : /save			(PUT MAPPING)
	
	DELETE BOOK : /delete/{id}	(DELETE MAPPING)

======================================================================================

USER AUTHENTICATION SERVICE :

Provides the following functionalities :
	-Register a new User
	-Login an existing User

	PORT : 8082
	
	BASE URL : /api/home/auth	
	
	REGISTER : /register		(PUT MAPPING)
	
	LOGIN : /login				(POST MAPPPING)

======================================================================================
	
USER SERVICE:

Provides the following functionalities :
	-Delete a USer
	-Update Details of an Existing User
	-Find a User
	
	PORT : 8083
	
	BASE URL : /api/home/user
	
	DELETE URL : /deleteUser/{id}	(DELETE MAPPING)
	
	UPDATE URL : /update/{id}		(UPDATE MAPPING)
	
	FIND URL : /find/{id}			(GET MAPPING)

======================================================================================
FAVOURITE SERVICE:

Provides the following functionalities :
	-Add a Book To Favourites List
	
	PORT:8084
	
	BASE URL : /api/home/user/favourite
	
	ADD FAVOURITE : /fav/addFavourite/{userId}	(PUT MAPPING)
	
	TOTAL COUNT : /fav/getCount/{userId}		(POST MAPING)

======================================================================================
	
SEARCH SERVICE:

Provides the following functionalities :
	-Search for a book by Book title or Author Name

	PORT:8085
	
	BASE URL : /api/home/user
	
	SEARCH URL : /search/{searchQuery}	(GET MAPPING)
	
======================================================================================
	
RECOMENDATION SERVICE:

Provides the following functionalities :
	-Recommends Books Based on book Subject
	
	PORT:8086
	
	BASE URL : /api/home/search/recomendation
	
	GET RECOMENDATIONS : /getRecomendations/{bookId}	(GET MAPPING)
	
======================================================================================
ORM - Object Relational Mapping

In User class should i put bookingId or booking object ? 
there is always this confusion right. How would database
communicate if i keep entire object inside another class ?

To solve this issue ORM layer came into picture.

1. It maps classes to database tables and vice-versa (get 
data from tables and store it inside class).
2. It helps to write SQL queries.

Lets hibernate create schema diagram for us. For that 
follow below steps.
1. Identify the cardinality among all tables.
2. Tell to spring.
3. Connect to database.

Non-primitives -
All for non-primitive data type identify the cardinalities 
and on top of it use JPA Annotations.

configure database in our application.
MySQL Workbench - is a client to interact with mysql database instead of using terminal.

----------

@Entity - this annotation tells spring to create table in the database.

@Id - tells spring a primary key, we should also tell spring how to generate primary key.

@GeneratedValue - tells spring how to generate primary key it has many strategies.
ex- @GeneratedValue(strategy=GeneratedValue.IDENTITY)

@MappedSuperclass - it tells spring to include all attributes in this class (super/base class)
in its child class tables.

Bec we don't want BaseModel a separate table in the database, we just want all the properties should be
copied to child class tables.

@Enumerated - tells spring its enum, we also need to tell how to generate.

ex - @Enumerated(EnumType.ORDINAL)

if there is a list of enums, along with @Enumerated Annotation we should also 
use @ElementCollection annotation , this creating mapping table.

Basically if we have a enum along with the list we have to add both the annotation.
@Enumerated and @ElementCollection, thats it.

--------------

@EntityListeners(AuditingEntityListener.class)

@LastModifiedDate
@Temporal(value = TemporalType.TIMESTAMP)

@CreatedDate
@Temporal(value = TemporalType.TIMESTAMP)

@EnableJpaAuditing

------------------

storing password using setters is not recommended in any companies.
Encrption has some disadvantages read about it.


Salting in password - read about it.

Bcrypt Library -

Rainbow table 




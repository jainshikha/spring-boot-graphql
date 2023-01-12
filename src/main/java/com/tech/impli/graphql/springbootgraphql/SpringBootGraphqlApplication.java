package com.tech.impli.graphql.springbootgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

}
/*
schema.graphqls file


#Person Input object is used to create or update a Person
input PersonInput {
    id: ID
    #a personal name given to someone at birth or baptism and used before a family name
    firstName: String!
    #a surname
    lastName: String!
    #An email address identifies an email box to which messages are delivered. ... An email address, such as john.smith@example.com, is made up from a local-part, the symbol @, and a domain name.
    emailAddress: String!
    #a number assigned to a telephone line for a specific phone or set of phones (as for a residence) that is used to call that phone. — called also phone number.
    officePhoneNumber: String
    #a number assigned to a telephone line for a specific phone or set of phones (as for a residence) that is used to call that phone. — called also phone number.
    mobilePhoneNumber: String
}

#Meeting Input object is used to create or update a Meeting
input MeetingInput {
    id: ID
    #The title s  hould describe the purpose of the meeting
    title: String!
    #The description should cover the details of the meeting's purpose.
    description: String
    #The person who setup the meeting
    organizer: PersonInput!
    #The people who will attend the meeting
    attendees: [PersonInput]
}

#Meeting API Mutations
type Mutation {
    #Creates a meeting
    createMeeting(meeting: MeetingInput!): Meeting
    #Updates a meeting
    updateMeeting(meeting: MeetingInput!): Meeting
    #Creates a person
    createPerson(person: PersonInput!): Person
    #Updates a person
    updatePerson(person: PersonInput!): Person
}

#Meeting API Subscription
type Subscription {
    #Fetch all people
    people: [Person]
}*/
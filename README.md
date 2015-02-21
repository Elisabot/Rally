Nike Hackathon Group 9

Rally - an application to cheer you on!


The Rally application will allow an active user to receive real-time motivation from their friends using the Nike+ Training Club app integrated with Google Glass. 

Feature/App:
The stand-alone Rally application is designed to be an added social feature for the Nike+ Training Club app, with the possibility of being incorporated into additional Nike+ apps. 

The Cheer:
Friends can send a pre-made cheer video, or record their own video or audio message.

How it works:
When a user starts a workout, their friends will receive a notification in their Sport Feed. (Friends can choose which users to subscribe to activities created.) The active user will be wearing Google Glass, which will poll their Nike+ Training Club app for cheers received. When one has been received, the Glass will play the pre-recorded cheer video, or upload the custom-recorded message.
The user should also have an icon by their name in the Friends list that indicates when they are currently active. Friends can then access the cheer features through the active user's profile. 

Privacy:
A user will need to subscribe to a friend to receive notifications in their Sport Feed. 
A user will need to enable activitiy notifications in order to allow subscribers to see when they become active and their active icon is lit.

API:
The active indicator can be populated with the API 
  GET https://api.nike.com/v1/{user}/sport/activities/latest - If the status of the latest activity is IN_PROGRESS, the user will receive an icon, that will enable the cheer features for that user.

The user profile should include a button that allows friends to subscribe to their changes in activity.
  see: https://developer.nike.com/documentation/api-docs/webhooks.html
  
The user should have the option of enabling push notifications when they become active or start a workout.
  see: privacy settings
  
When a user has subscribed to a friend who has agreed to notify their friends when they become active, any workout that is started will push a notification to their friends. They will receive an icon by their name in the friends list. Cheer featuers will be enabled.

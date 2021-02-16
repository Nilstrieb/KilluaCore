# KilluaCore

The core systems of the KilluaBot. Can be used to create any bot with JDA.

## What is handled in KilluaCore?

### Commands

You don't have to care about the command handling at all. You can just create a command in the commands package and then
add it in the `Main` class in the `addCommands()` method by just instantiating it.

To create a new command, just add a new class that extends `Command`. You are forced to override a method that is called
when the command is entered. You can do all handling there. Sending a method to the text channel the command invocation
came from can be done with `reply("text");` (the method just calls `event.getTextChannel().sendMessage("text").queue();`
if you're familiar with JDA).

The event is stored as a field and can be accessed with `event`.

### MultiPageEmbed

You can create embeds that consist of multiple pages and can be navigated with reactions. Creating one is very easy:
First, you create an Array of `MessageEmbed`, one for each page. Then you call `reply(array);` with the array as a
parameter. A message will be sent containing the pages. You can also customize the reactions.

### Sections

If you need the user to give input for mulitple messages, you can use a `Section`. For this, just create a new class (I
recommend it being a subclass of the command class) that extends `Section`. You then get a method `called(String text)`
that gets called everytime the user replies to the section. A section can be closed with `dispose()`.

### Help Command

A fully workng help command is generated automatically by the `CommandHandler`. You can hide commands from it by setting
the boolean `hidden` in the superconstructor to true.

## Examples

For examples, visit the [KilluaBot](https://github.com/Nilstrieb/KilluaBot) repo on Github.

## How to use this

You can just download the code here and copy it into your own bot. No crediting is required, but I'd appreciate it if
you linked or mentioned KilluaCore somewhere in you project, but you don't have to. 
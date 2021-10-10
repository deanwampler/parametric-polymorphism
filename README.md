# Parametric Polymorphism

Dean Wampler, October 2021.

This repo is the code for the [Scala 3 Medium](https://medium.com//scala-3) post on [The Value of Parametric Polymophism](https://medium.com/scala-3/the-value-of-parametric-polymophism-e76bfb9a516b).

Try the examples by starting `sbt`, then use `run`, then pick the example to run from the list.

The example versions, `v1` through `v4` evolve the example:

| Version  | Description |
| :------- | :---------- |
| `v1`     | Don't attempt to use a parametric polymorphic implementation for message handling. Rather, just declare custom handler types for each message type, with lots of duplication. The `MessageHandler.apply` method could be concrete, as all subtype implementations are identical. I left it as shown because in `v3` I deal with the case where they aren't identical. |
| `v2`     | Use parametric polymorphism, where one type handles all details and `given` instances are declared for each input message type. |
| `v3`     | Use parametric polymorphism and the [Template Method Pattern](https://en.wikipedia.org/wiki/Template_method_pattern) to handle the situation where the message handling is actually different for each message.  `MessageHandler.apply` is a concrete _template_, which implements what's common to all variants. It calls the abstract protected `process` method that each concrete class must implement for unique handling. Two other protected methods `success` and `failure` are helper methods. |
| `v4`     | Show how easy and robust it is to add a new message type. |
| `v4java` | A Java implementation of `v4` to show you how to apply these techniques in Java code. |

There is also

Finally, see the branch `with-enums`, which uses `enum` declarations for the `IncomingMessage` and `OutgoingMessage` hierarchies. The code comments discuss a limitation you encounter when using `enums`, namely an extra `given` instance has to be declared for `MessageHandler[IncomingMessage]`, which is not needed in the implementation that uses a trait and case classes. The difference is due to typing differences involving `enum` `cases` vs. a hierarchy using a base trait with subtypes, as done here.

Also, `enums` wouldn't work for hierarchies that aren't sealed, i.e., where a client needs the ability to add new message types, as shown in `v4`, which still plug into the "infrastructure".


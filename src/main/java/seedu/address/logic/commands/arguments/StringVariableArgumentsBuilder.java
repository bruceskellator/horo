package seedu.address.logic.commands.arguments;

public class StringVariableArgumentsBuilder extends VariableArgumentsBuilder<String> {

    StringVariableArgumentsBuilder(String description) {
        super(description);
    }

    @Override
    VariableArguments<String> argumentBuild() {
        return new StringVariableArguments(this);
    }
}

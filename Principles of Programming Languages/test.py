import tokenize
import io

def fix_indentation(code):
    # Tokenize the code and get a list of tokens
    tokens = tokenize.generate_tokens(io.StringIO(code).readline)
    token_list = [t.string for t in tokens]
    print (token_list)
    # Store the fixed lines of code
    fixed_lines = []
    # Keep track of the current indentation level
    current_indent = 0
    expected_indent = 0
    # Keep track of the line number
    line_number = 1

    # Loop through each token and check for indentation errors
    for toknum, tokval, (srow, scol), (erow, ecol), line in tokens:
        # If this is the start of a new line, check the indentation level
        if toknum == tokenize.NEWLINE:
            # If the current indentation level is less than the expected indentation level, fix it
            if current_indent < expected_indent:
                fixed_lines[-1] = (" " * current_indent) + fixed_lines[-1].lstrip()
            # If the current indentation level is greater than the expected indentation level, fix it
            elif current_indent > expected_indent:
                fixed_lines[-1] = fixed_lines[-1][(expected_indent - current_indent):]

            # Reset the expected indentation level
            expected_indent = 0

        # If this is an indent token, set the expected indentation level
        elif toknum == tokenize.INDENT:
            expected_indent = scol

        # If this is a dedent token, set the expected indentation level to the previous level
        elif toknum == tokenize.DEDENT:
            expected_indent = current_indent

        # Store the current line with any fixes applied
        if toknum != tokenize.INDENT:
            fixed_lines.append(line)
        # Update the current indentation level
        current_indent = scol

    # Join the fixed lines back into a single string
    fixed_code = "".join(fixed_lines)

    return fixed_code

def count_print_statements(code):
    # Tokenize the code and get a list of tokens
    tokens = tokenize.generate_tokens(io.StringIO(code).readline)

    # Keep track of the number of print statements
    num_print_statements = 0

    # Loop through each token and count the number of print statements
    for toknum, tokval, (srow, scol), (erow, ecol), line in tokens:
        if toknum == tokenize.NAME and tokval == "print":
            num_print_statements += 1

    return num_print_statements

# Example usage
input_file_path = "input.py"
output_file_path = "output.txt"

# Read the input file
with open(input_file_path, "r") as input_file:
    input_program = input_file.read()

# Perform the desired operations
fixed_program = fix_indentation(input_program)
num_print_statements = count_print_statements(fixed_program)

# Write the output file
with open(output_file_path, "w") as output_file:
    output_file.write("Original code:\n")
    output_file.write(input_program)
    output_file.write("\n\nFixed code:\n")
    output_file.write(fixed_program)
    output_file.write(f"\n\nNumber of print statements: {num_print_statements}\n")
    
print("Results written to output file:", output_file_path)

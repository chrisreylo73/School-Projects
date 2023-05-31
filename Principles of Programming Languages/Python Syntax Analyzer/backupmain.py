import ast


def fix_indentation(node):
    for child in ast.iter_child_nodes(node):
        if isinstance(child, ast.FunctionDef):
            child.col_offset = 4
        fix_indentation(child)


def fix_function_header(node):
    if isinstance(node, ast.FunctionDef):
        try:
            ast.get_docstring(node)
        except SyntaxError as e:
            if e.offset > len("invalid syntax ("):
                # This is a header syntax error
                fixed_source = f"def {node.name}({node.args.args[0].arg}, {e.text.strip()}){ast.get_source_segment(node.args)}"
                fixed_tree = ast.parse(fixed_source)
                node.args.args = fixed_tree.body[0].args.args


def count_print_statements(node):
    count = 0
    if isinstance(node, ast.Expr) and isinstance(node.value, ast.Call) and \
       isinstance(node.value.func, ast.Name) and node.value.func.id == 'print':
        count += 1
    for child in ast.iter_child_nodes(node):
        count += count_print_statements(child)
    return count


# This version handles IndentationError as a special case, 
# by locating the offending line and column in the original source code, 
# then adjusting the whitespace to fix the indentation. 
# It then tries to re-parse the source code with the corrected indentation. 
# If there's still an error, it falls back to the existing error handling code.

def fix_python_program(source):
    try:
        tree = ast.parse(source)
    except IndentationError as e:
        lineno, offset = e.args[1][1], e.args[1][2]
        lines = source.split('\n')
        lines[lineno-1] = ' ' * offset + lines[lineno-1].lstrip()
        source = '\n'.join(lines)
        return fix_python_program(source)
    except SyntaxError as e:
        return f"Syntax error: {e.msg} (line {e.lineno}, column {e.offset})", 0
    else:
        fix_indentation(tree)
        fix_function_header(tree)
        count = count_print_statements(tree)
        return ast.unparse(tree), count


def main(input_file, output_file):
    with open(input_file, 'r') as f:
        source = f.read()
    fixed_source, count = fix_python_program(source)
    with open(output_file, 'w') as f:
        f.write("Original program:\n")
        f.write(source)
        f.write("\n\n")
        f.write("Updated program:\n")
        f.write(fixed_source)
        f.write("\n\n")
        f.write("Number of times 'print' was used: " + str(count))


if __name__ == '__main__':
    input_file = 'badHeaders.py'
    output_file = 'output.txt'
    main(input_file, output_file)

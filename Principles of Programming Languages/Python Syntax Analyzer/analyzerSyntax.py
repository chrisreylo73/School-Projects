
""" 
The module ast provides a way to parse and manipulate the syntax of Python code in a structured way.
"""
import ast


def fix_indentation(node):
    for child in ast.iter_child_nodes(node):
        if isinstance(child, ast.FunctionDef):
            child.col_offset = 4
        fix_indentation(child)


def fix_function_header(node):
    if isinstance(node, ast.FunctionDef):
        if not node.args.args:
            arg = ast.arg(arg='self', annotation=None)
            node.args.args.append(arg)


def count_print_statements(node):
    count = 0
    if isinstance(node, ast.Expr) and isinstance(node.value, ast.Call) and \
       isinstance(node.value.func, ast.Name) and node.value.func.id == 'print':
        count += 1
    for child in ast.iter_child_nodes(node):
        count += count_print_statements(child)
    return count


def fix_python_program(source):
    tree = ast.parse(source)
    print("Before fixing indentation:")
    print(ast.dump(tree, indent=4))
    fix_indentation(tree)
    print("After fixing indentation:")
    print(ast.dump(tree, indent=4))
    fix_function_header(tree)
    count = count_print_statements(tree)
    print("Number of times 'print' was used:", count)
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

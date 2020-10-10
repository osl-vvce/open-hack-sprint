use std::io;

fn main() {
    let mut a: i32;
    let mut b: i32;
    let mut input = String::new();
    println!("Enter expression in \"a + b\" format with space separating the number and operator.");
    io::stdin()
        .read_line(&mut input)
        .expect("Error");
    let mut inparr: Vec<&str> = input.trim().split_whitespace().collect();
    a = inparr[0].parse().unwrap();
    b = inparr[2].parse().unwrap();
    match inparr[1] {
        "+" => println!("{}", a + b),
        "-" => println!("{}", a - b),
        "*" => println!("{}", a * b),
        "/" => {
            if b != 0 {
                println!("{}", a / b);
            } else {
                println!("Can't divide by 0.");
            }
        },
        "%" => println!("{}", a % b),
        _ => println!("Unknown operator."),
    }
}

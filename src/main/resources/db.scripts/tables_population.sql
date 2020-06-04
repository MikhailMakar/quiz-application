INSERT INTO public.answer(answer_value, is_correct, question_id)
	VALUES ('Yes', true, 1);

INSERT INTO public.question(question_value, quiz_id)
	VALUES ('Do you like sun?', 1);

INSERT INTO public.quiz(quiz_name)
	VALUES ('First quiz');

INSERT INTO public.user_role(user_table_id, role)
	VALUES (1, 'ROLE_USER');

INSERT INTO public.user_table(first_name, last_name)
	VALUES ('John', 'Wick');
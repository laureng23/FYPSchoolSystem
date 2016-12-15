json.extract! book, :id, :title, :author, :genre_id, :available, :cover, :created_at, :updated_at
json.url book_url(book, format: :json)
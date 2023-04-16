interface EventHandler<E> {
    fun obtainEvent(event: E)
}
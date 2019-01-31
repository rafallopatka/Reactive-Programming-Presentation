val subject = BehaviourSubject.create<UUID>()

override fun onViewCreated(args: ViewArgs){
    subject.onNext(args)
}

subject.subscribe {  args -> }